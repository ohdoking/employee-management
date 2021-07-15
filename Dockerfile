FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
ARG DEPENDENCY=/build/dependency
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "/app:/app/lib/*","com.ohdoking.employeemanagement.EmployeeManagementApplication"]