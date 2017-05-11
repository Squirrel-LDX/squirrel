# squirrel

----------

### **项目结构：**

 - com.ldu.pojo:普通的java实体类（自动生成，勿更改）
 - com.ldu.dao:数据持久层（Dao）接口（自定生成的方法勿删，根据需求自己添加方法）
 - com.ldu.service:业务逻辑层接口（根据功能添加方法）
 - com.ldu.service.impl:业务逻辑层的实现类，调用Dao层接口中的方法实现业务逻辑
 - com.ldu.contorller:控制层，调用Service中的接口进行控制

Dao层的实现使用的是MyBatis的xml文件，而非java类，此处暂时不用写。
Dao层接口中的增删改查方法传参尽量使用对象，例如`int updateByPrimaryKey(User record);`


### 时间：2017年5月10日
### 作者：llwwlql
### 内容：  
- 商品页面目录都为goods/...,例如商品信息修改页面goods/editGoods.jsp
