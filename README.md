# sharding-jdbc-demo

Maven项目：@Override is not allowed when implement interface method

由于我的项目是maven类型项目，所以在pox.xml的<build></build>标签中添加如下代码，即可解决问题。
https://blog.csdn.net/chengyuqiang/article/details/54600499


  <build><br>
    <finalName>spirngMVC</finalName><br>
    <plugins><br>
      <!-- 编码和编译和JDK版本 --><br>
      <plugin><br>
        <groupId>org.apache.maven.plugins</groupId><br>
        <artifactId>maven-compiler-plugin</artifactId><br>
        <version>2.3.2</version><br>
        <configuration><br>
          <source>1.8</source><br>
          <target>1.8</target><br>
          <encoding>utf8</encoding><br>
        </configuration><br>
      </plugin><br>
    </plugins><br>
  </build><br>


我的本地数据库信息数据库：<br>
用户名：root<br>
数据库密码：lixing20080830<br>
