package com.example.testcommon.commom.algorithm.snowflake;

import java.util.Random;

public class SnowflakeIdGenerator {

    // ==============================字段==============================

    private static Random random = new Random();

    // 机器ID
    private final long workerId;
    // 数据中心ID
    private final long datacenterId;
    // 序列号
    private long sequence = 0L;


    // 配置参数
    private static final long MAX_WORKER_ID = 31L;
    private static final long MAX_DATACENTER_ID = 31L;
    private static final long TIMESTAMP_BITS = 41L;
    private static final long MAX_TIMESTAMP = ~(-1L << TIMESTAMP_BITS);
    private static final long WORKER_ID_BITS = 5L;
    private static final long DATACENTER_ID_BITS = 5L;
    private static final long SEQUENCE_BITS = 12L;

    // 位移偏移量
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS + DATACENTER_ID_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS;

    // 上次生成ID的时间戳
    private long lastTimestamp = -1L;


    // ==============================构造函数==============================

    private static SnowflakeIdGenerator instance = null;

    static {
        instance = new SnowflakeIdGenerator();
    }

    private SnowflakeIdGenerator() {
        this(random.nextInt(31), random.nextInt(31));
    }


    /**
     * 构造函数
     *
     * @param workerId     机器ID (0 - 31)
     * @param datacenterId 数据中心ID (0 - 31)
     */
    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        // 检查workerId和datacenterId是否合法
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException("Worker ID must be between 0 and " + MAX_WORKER_ID);
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException("Datacenter ID must be between 0 and " + MAX_DATACENTER_ID);
        }

        // 设置workerId和datacenterId
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }


    // ==============================方法==============================


    public static SnowflakeIdGenerator getInstance() {
        return instance;
    }

    /**
     * 生成唯一ID
     *
     * @return 唯一ID
     */
    public synchronized long generateUniqueId() {
        long timestamp = getCurrentTimestamp();

        // 检查时钟回退情况
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate ID.");
        }

        // 同一毫秒内自增序列号
        if (timestamp == lastTimestamp) {
            // 自增并掩码
            sequence = (sequence + 1) & ((1 << SEQUENCE_BITS) - 1);
            if (sequence == 0) {
                // 序列号用完，等待下一毫秒
                timestamp = getNextTimestamp(lastTimestamp);
            }
        } else {
            // 不同毫秒重置序列号
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // 组合生成唯一ID
        return ((timestamp << TIMESTAMP_SHIFT) |
                (datacenterId << DATACENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) |
                sequence);
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳（毫秒）
     */
    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 等待下一毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间戳
     * @return 新的时间戳
     */
    private long getNextTimestamp(long lastTimestamp) {
        long timestamp = getCurrentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }
        return timestamp;
    }

    // ==============================测试==============================


    public static void main(String[] args) {
        // 创建一个雪花算法生成器，传入机器ID和数据中心ID
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(0, 0);
        // 生成10个唯一ID并打印
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                long uniqueId = idGenerator.generateUniqueId();
                System.out.println("Generated Unique ID: " + uniqueId);
            }).start();
        }
    }
}