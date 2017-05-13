# squirrel
项目代码

需要实现的功能：
在UserController中，public ModelAndView goods()方法中：
我已经将登陆用户的闲置物品给获取出，如何将商品与image表中的imgurl关联起来。

我需要循环输出：

```
<c:forEach var="l" items="${list}">
  <tr>
    <td>${l.id}</td>
    <td>${l.name}</td>
    <td>
    /**url怎么写?**/
      <img src="${basePath}upload/${.url}" class="pic"/>
    </td>
  </tr>
</c:forEach>
```
