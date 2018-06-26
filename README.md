# sharding-jdbc-demo

Maven项目：@Override is not allowed when implement interface method

由于我的项目是maven类型项目，所以在pox.xml的<build></build>标签中添加如下代码，即可解决问题。


  <build>
    <finalName>spirngMVC</finalName>
    <plugins>
      <!-- 编码和编译和JDK版本 -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.3.2</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
          <encoding>utf8</encoding>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>



我的本地数据库信息数据库：
用户名：root
数据库密码：lixing20080830
