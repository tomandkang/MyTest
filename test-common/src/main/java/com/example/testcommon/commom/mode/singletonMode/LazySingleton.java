package com.example.testcommon.commom.mode.singletonMode;

public class LazySingleton {

    //保证 instance 在所有线程中同步
    private static volatile LazySingleton instance = null;

    //private 避免类在外部被实例化
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        // 检查实例是否存在，不存在则进入下一步
        if (instance == null) {
            synchronized (LazySingleton.class) {
                //getInstance 方法前加同步
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
