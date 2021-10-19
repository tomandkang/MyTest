package com.yks.pls.dao;

import com.yks.pls.amazon.dto.AmazonTempInsertDTO;
import com.yks.pls.amazon.dto.TempInsertDTO;
import com.yks.pls.amazon.dto.UpdateLibraryDTO;
import com.yks.pls.annotation.MyBatisDao;
import com.yks.pls.dto.PlsProductIdLibraryDTO;
import com.yks.pls.model.PlsProductIdLibrary;
import com.yks.pls.vo.PlsProductIdLibraryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 产品ID库 DAO
 * @author: gaoliangyou
 * @version: 2019/07/18 14:55
 */
@MyBatisDao
public interface IPlsProductIdLibraryDAO extends CrudDAO<PlsProductIdLibrary> {

    /**
     * @return
     * @Description 根据 id 获取产品ID库信息
     * @Author gaoliangyou
     * @Param id
     * @Version 2019/08/02 13:06
     */
    PlsProductIdLibrary getPlsProductIdLibraryById(String id) throws Exception;

    /**
     * @return
     * @Description 根据 id 删除产品库信息
     * @Author gaoliangyou
     * @Param id
     * @Version 2019/07/18 14:55
     */
    int deleteById(String id) throws Exception;

    /**
     * @return
     * @Description 根据条件(平台 / 产品ID类型 / 产品ID)获取产品库信息总数
     * @Author gaoliangyou
     * @Param plsProductIdLibraryDTO
     * @Version 2019/08/02 11:26
     */
    long getProductIdLibraryCount(PlsProductIdLibraryDTO plsProductIdLibraryDTO) throws Exception;

    /**
     * @return
     * @Description 根据条件(平台 / 产品ID类型 / 产品ID)获取产品库信息列表
     * @Author gaoliangyou
     * @Param plsProductIdLibraryDTO
     * @Version 2019/07/18 14:55
     */
    List<PlsProductIdLibraryVO> getProductIdLibraryList(PlsProductIdLibraryDTO plsProductIdLibraryDTO) throws Exception;

    /**
     * @return
     * @Description 根据id查询数据
     * @Author gaoliangyou
     * @Param id
     * @Version 2019/07/18 21:06
     */
    Integer queryUseStatusById(@Param("id") String id) throws Exception;

    /**
     * @return
     * @Description 批量插入产品ID库信息
     * @Author gaoliangyou
     * @Param plsProductIdLibraryDTOList
     * @Version 2019/07/18 14:55
     */
    void batchInsert(@Param("list") List<PlsProductIdLibraryDTO> plsProductIdLibraryDTOList) throws Exception;

    /**
     * @return
     * @Description 根据平台及产品ID类型获取产品ID
     * @Author wuxin
     * @Param
     * @Version 2019/8/6 19:09
     */
    Long getProductIdByPlatformAndType(@Param("platform") int platform, @Param("productIdTypeCode") Integer productIdTypeCode) throws Exception;

    /**
     * @return
     * @Description 根据平台、产品ID类型、提取数获取productId
     * @Author wuxin
     * @Param
     * @Version 2019/8/9 10:33
     */
    List<String> getProductIdByPlatformAndTypeAndCount(@Param("platformCode") int platformCode, @Param("productIdTypeCode") Integer productIdTypeCode, @Param("count") long count) throws Exception;

    /**
     * @return
     * @Description 根据平台、产品ID类型、产品ID 修改使用状态
     * @Author wuxin
     * @Param
     * @Version 2019/8/9 10:39
     */
    long updateProductIdUseStatus(@Param("platformCode") int platformCode,
                                  @Param("productIdTypeCode") Integer productIdTypeCode,
                                  @Param("productIdList") List<String> productIdList,
                                  @Param("useStatus") int useStatus) throws Exception;

    /**
     * @return
     * @Description 批量查找产品ID信息
     * @Author gaoliangyou
     * @Param productIdLibraryDTOList
     * @Date 2019/9/5 17:50
     */
    List<PlsProductIdLibraryDTO> getProductIdLibraryListBatch(@Param("list") List<PlsProductIdLibraryDTO> productIdLibraryDTOList);

    /**
     * @param platform    平台
     * @param type        产品类型
     * @param status      状态
     * @return {@link int}
     * @Description 根据销售账号查询未使用的ean数量
     * @Author tanghuanran
     * @Version 2021/7/17 14:18
     */
    int countEanNum(@Param("platform") int platform, @Param("type") int type, @Param("status") int status);

    /**
     * @param merchantToken 卖家标识
     * @param start         修改起始
     * @param range         修改结束
     * @Description 为当前用户设置一百条未使用的ean
     * @Author tanghuanran
     * @Version 2021/7/17 14:35
     */
    int setShopAccountLimitOneHundred(@Param("merchantToken") String merchantToken, @Param("start") int start, @Param("range") int range);

    /**
     * @param platform      平台
     * @param productType   产品类型
     * @param sellerSkuList 指定数量
     * @param merchantToken 卖家标识
     * @return {@link List<String>}
     * @Description 根据平台、 产品类型、 销售账号获取指定数量产品id
     * @Author tanghuanran
     * @Version 2021/7/17 17:13
     */
    List<PlsProductIdLibrary> getProductIdWithCondition(@Param("platform") Integer platform,
                                                        @Param("productType") Integer productType,
                                                        @Param("sellerSkuList") List<String> sellerSkuList,
                                                        @Param("merchantToken") String merchantToken);

    /**
     * @param productIdLibraryList 产品ID库对象
     * @Description 根据卖家标识和销售账号给sellerSku赋值
     * @Author tanghuanran
     * @Version 2021/8/16 14:05
     */
    int updateSellerSkuWithCondition(@Param("productIdLibraryList") List<PlsProductIdLibrary> productIdLibraryList);

    /**
     * @param merchantToken 卖家标识
     * @return {@link int}
     * @Description 根据卖家标识计数未使用ean数量
     * @Author tanghuanran
     * @Version 2021/8/16 17:26
     */
    int countUnUsedEanNum(@Param("merchantToken") String merchantToken);

    /**
     * @param platform      站点
     * @param productType   ean
     * @param merchantToken 卖家标识
     * @param size          获取数量
     * @return {@link List<PlsProductIdLibrary>}
     * @Description 根据条件获取未使用的对应卖家标识的ean
     * @Author tanghuanran
     * @Version 2021/8/16 22:52
     */
    List<PlsProductIdLibrary> getLibraryWithCondition(@Param("platform") Integer platform,
                                                      @Param("productType") Integer productType,
                                                      @Param("merchantToken") String merchantToken,
                                                      @Param("size") int size);

    /**
     * @param merchantToken 卖家标识
     * @return {@link int}
     * @Description 根据卖家标识查询亚马逊未分配的ean数量
     * @Author tanghuanran
     * @Version 2021/8/19 14:55
     */
    int countUnusedEanWithMerchantToken(@Param("merchantToken") String merchantToken);

    /**
     * @Description 查询已刊登成功或者刊登失败的数据
     * @Author tanghuanran
     * @return {@link List<UpdateLibraryDTO>}
     * @Version 2021/8/24 16:17
     */
    List<UpdateLibraryDTO> selectWithCondition(@Param("list") List<UpdateLibraryDTO> updateLibraryList);

    /**
     * @Description 批量修改状态
     * @Author tanghuanran
     * @Version 2021/8/24 16:21
     */
    void batchUpdateStatus(@Param("list") List<UpdateLibraryDTO> updateLibraryList);

    /**
     * @Description 获取所有的卖家标识
     * @Author tanghuanran
     * @return {@link List<String>}
     * @Version 2021/8/24 17:34
     */
    List<String> getAllMerchantToken();

    List<TempInsertDTO> tempGetAllAlreadyLibraryId();

    List<TempInsertDTO> tempSelectWithCondition(@Param("list") List<TempInsertDTO> tempInsertList);

    void tempBatchInsert(@Param("list") List<TempInsertDTO> insertList);

    void tempBatchUpdate(@Param("list") List<TempInsertDTO> updateList);

    void clearAllEanByMerchantTokens(@Param("list") List<String> merchantTokenList);


    void batchInsertTempInsertDTO(@Param("list") List<AmazonTempInsertDTO> tempInsertDTOS);

}
