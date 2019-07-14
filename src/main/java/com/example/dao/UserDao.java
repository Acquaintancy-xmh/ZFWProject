package com.example.dao;


import com.example.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    String TABLE_NAME = " User ";
    String INSERT_FIELDS = " name, password, salt, headUrl ,role ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values (#{name},#{password},#{salt},#{headUrl},#{role})"})
    public void insertUser(User user);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id=#{id}"})
    public User seletById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where name=#{name}"})
    public User seletByName(@Param("name") String name);

    @Delete({"delete from",TABLE_NAME,"where id=#{id}"})
    public void deleteById(int id);
}
