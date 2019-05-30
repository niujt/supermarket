package supermarket.dao;

import com.wxthxy.supermarket.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderDAO {
    /**
     * 查询所有的供应商信息
     *
     * @return
     */
    List<Provider> providerlist();

    /**
     * 按条件分页查询供应商信息
     *
     * @return 供应商列表
     */
    List<Provider> getProviderList(Integer page, Integer limit, String proCode, String proName);

    /**
     * 查找符合条件的总记录数
     * @return 查询到的条数
     */
    int getCount();

    /**
     * 保存要添加的供应商信息
     *
     * @param provider 供应商
     * @return 添加的条数
     */
    int saveprovider(Provider provider);

    /**
     * 根据供应商id查找供应商
     *
     * @param id 供应商id
     * @return 供应商
     */
    Provider getProviderbyid(@Param("id") Integer id);

    /**
     * 修改供应商
     *
     * @param provider 供应商
     * @return 修改的的条数
     */
    int updateProviderbyid(Provider provider);

    /**
     * 删除供应商
     *
     * @param id 供应商id
     * @return 删除的条数
     */
    int deleteproviderbyid(@Param("id") Integer id);
    Provider getProviderbyName(@Param("proName") String proName);
}