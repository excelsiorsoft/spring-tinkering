rem start /B C:\spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64\sts-3.6.4.RELEASE\STS.exe -data "E:\source\spring-tinkering" -clean -showlocation -vmC:\Java\java-8 -vmargs -Xmx1024m -XX:MaxPermSize=256m -javaagent:lombok.jar -Xbootclasspath/a:E:\source\spring-tinkering\lombok.jar

rem start /B C:\spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64\sts-3.6.4.RELEASE\STS.exe -data "E:\source\spring-tinkering" -clean -showlocation -vmC:\Java\java-8 -vmargs -Xmx1024m -XX:MaxPermSize=256m -javaagent:lombok.jar -Xbootclasspath/a:lombok.jar

start /B C:\"Program Files"\SpringTools4\sts-4.0.0.M7\SpringToolSuite4.exe -data %~dp0 -clean -showlocation -vmC:\Java\jdk1.8.0_144\bin\java.exe -vmargs -Xmx1024m -XX:MaxPermSize=256m -javaagent:lombok.jar -Xbootclasspath/a:lombok.jar