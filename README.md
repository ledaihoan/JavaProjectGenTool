# JavaProjectGenTool
provide convenient way for daily developments to quickly and accurately generate Java project  

# Usage
```
./prjgen.cmd PrjName
```
After this command, a PrjName folder generated - a standard Gradle Java project. You can move this folder into your prefer path such as your working space,...

# Build Project
From your project root folder, run below command
```
./gradlew build
```
# Run Project
There are 2 parameters you need to care in build.gradle files
- mainClassName: package.MainClass for execution
- applicationDefaultJvmArgs: JVM arguments for runtime with required args (appname, appprof)
## For development
You can run from IDE, should choose IntelliJ (automatically delegate project build task to Gradle), other IDE need "Gradle task deletgate..." config to work properly.
Alternative, you can run the project from terminal
```
./gradlew run
```
## For production (UNIX System only)
First, you need to build project
```
./gradlew clean build
```
- After this, ProjectName.zip is created under $PROJECT_ROOT/build/distributions/ directory.
- Deploy unzipped folder into your servers. We call this as "$DIST"
- execute $DIST/bin/YourProjectName bash script to run project and you're all set. In this folder a ".bat" file for Windows exist too. But I will not mention about Windows.
```
user@Server:..$YourProject/bin$ ./YourProjectName
```
- To stop your app: run "stop" in the same "bin" folder
```
user@Server:..$YourProject/bin$ ./stop
```
More bashscript will be added soon for better monitoring support
