# spring cloud 测试


    <profiles>
        <profile>
            <id>dev</id>
            <properties>
                <spring.profile.active>dev</spring.profile.active>
            </properties>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
        </profile>
        <profile>
            <id>prod</id>
            <properties>
                <spring.profile.active>prod</spring.profile.active>
            </properties>
            <!--<activation>
                <activeByDefault>true</activeByDefault>
            </activation>-->
        </profile>

    </profiles>
