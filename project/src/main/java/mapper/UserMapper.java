package mapper;

import java.util.List;
import java.util.Map;

import pojo.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbggenerated Wed Aug 24 11:28:39 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbggenerated Wed Aug 24 11:28:39 CST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbggenerated Wed Aug 24 11:28:39 CST 2022
     */
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbggenerated Wed Aug 24 11:28:39 CST 2022
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbggenerated Wed Aug 24 11:28:39 CST 2022
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据账号密码查询数据
     * @param map 传入参数
     * @return user
     */
    User selectUserByUsernameAndPsw(Map<String,Object> map);
}