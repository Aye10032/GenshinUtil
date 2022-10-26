# GenshinUtil
## 米游社原神信息查询工具
[![](https://jitpack.io/v/Aye10032/GenshinUtil.svg)](https://jitpack.io/#Aye10032/GenshinUtil)    
调用米游设接口，可以查询人物等级、技能、圣遗物等等   
具体返回数值可见注释    

## 使用方式

### gradle
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {   
    repositories {    
        ...   
        maven { url 'https://jitpack.io' }    
    }   
}   
```   

Step 2. Add the dependency    
```   
dependencies {    
    implementation 'com.github.Aye10032:GenshinUtil:Tag'    
}   
```   

### maven

Step 1. Add the JitPack repository to your build file   

```   
	<repositories>    
		<repository>    
		    <id>jitpack.io</id>   
		    <url>https://jitpack.io</url>   
		</repository>   
	</repositories>   
```   

Step 2. Add the dependency    
```   
	<dependency>    
	    <groupId>com.github.Aye10032</groupId>    
	    <artifactId>GenshinUtil</artifactId>    
	    <version>Tag</version>    
	</dependency>   
```   
