把下面完整内容复制到 `README2.md`：

```markdown
# InventoryRollbackPlus 个人定制版

这是基于 `TechnicallyCoded/Inventory-Rollback-Plus` 1.8.4 源码制作的个人维护版本，适用于 Paper、Leaves 等 Bukkit/Paper 服务端。

## 一、插件用途

InventoryRollbackPlus 用于保存和恢复玩家的：

- 主背包
- 末影箱
- 生命值
- 饥饿值
- 经验等级
- 死亡位置
- 玩家历史备份

常用命令：

```text
/ir restore <玩家>
/ir forcebackup <玩家>
/ir enable
/ir disable
/ir reload
```

## 二、编译环境

推荐使用以下环境：

- Windows 10/11 64 位
- JDK 8
- Maven 3.8 或更高版本
- IntelliJ IDEA
- Git

下载链接：

- JDK 8：https://adoptium.net/temurin/releases/?version=8
- Maven：https://maven.apache.org/download.cgi
- IntelliJ IDEA：https://www.jetbrains.com/idea/download/
- Git：https://git-scm.com/downloads
- 原作者仓库：https://github.com/TechnicallyCoded/Inventory-Rollback-Plus
- 个人 Fork 仓库：https://github.com/MGHYGitHub/Inventory-Rollback-Plus

## 三、项目目录

当前项目目录：

```text
D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus
```

项目根目录必须包含：

```text
pom.xml
BukkitVersion-0.0.22.jar
src\main\java\
src\main\resources\
```

`BukkitVersion-0.0.22.jar` 是本项目编译所需的本地依赖，不能删除。

## 四、安装 BukkitVersion 本地依赖

打开 PowerShell，执行：

```powershell
cd 'D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus'

mvn install:install-file `
  "-Dfile=D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus\BukkitVersion-0.0.22.jar" `
  "-DgroupId=com.tcoded.lightlibs" `
  "-DartifactId=BukkitVersion" `
  "-Dversion=0.0.22" `
  "-Dpackaging=jar" `
  "-Dmaven.repo.local=C:\Users\29706\.m2\repository"
```

注意：

- 每个 `-D` 参数都建议使用双引号。
- PowerShell 的反引号 `` ` `` 表示换行，不能漏掉。
- 如果命令被网页复制成一行，也可以写成一整行：

```powershell
mvn install:install-file "-Dfile=D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus\BukkitVersion-0.0.22.jar" "-DgroupId=com.tcoded.lightlibs" "-DartifactId=BukkitVersion" "-Dversion=0.0.22" "-Dpackaging=jar" "-Dmaven.repo.local=C:\Users\29706\.m2\repository"
```

## 五、Maven 编译

安装本地依赖后执行：

```powershell
cd 'D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus'

mvn clean package "-DskipTests=true" "-Dmaven.repo.local=C:\Users\29706\.m2\repository"
```

编译成功后，生成的插件位于：

```text
target\InventoryRollbackPlus-1.8.4.jar
```

如果想保留测试，也可以去掉：

```text
-DskipTests=true
```

## 六、IntelliJ IDEA 配置

1. 使用 IDEA 打开项目根目录。
2. 选择 `pom.xml` 作为 Maven 项目导入。
3. 打开“文件 → 项目结构 → 项目”。
4. 将项目 SDK 设置为 JDK 8。
5. 打开“设置 → 构建、执行、部署 → 构建工具 → Maven”。
6. 确认 Maven 本地仓库为：

```text
C:\Users\29706\.m2\repository
```

7. 在 IDEA 右侧 Maven 面板中执行：

```text
Lifecycle → clean
Lifecycle → package
```

8. 如果提示找不到 BukkitVersion，先执行第四节的本地依赖安装命令，然后点击 Maven 面板中的“重新加载所有 Maven 项目”。

## 七、本次个人定制内容

本版本基于上游 `1.8.4` 源码，版本号保持为 `1.8.4`。

本次主要进行了中文 GUI 定制：

| 原文本 | 中文文本 |
|---|---|
| Inventory Rollback | 库存回滚 |
| Player Data | 玩家数据 |
| Rollbacks | 回滚记录 |
| Main Inventory Backup | 主背包备份 |
| Ender Chest Backup | 末影箱备份 |
| Deaths | 死亡记录 |
| Joins | 加入记录 |
| Quits | 退出记录 |
| World Changes | 世界变更 |
| Force Saves | 强制保存 |
| backup(s) available | 个可用备份 |

涉及的源码文件：

```text
src\main\java\me\danjono\inventoryrollback\gui\InventoryName.java
src\main\java\me\danjono\inventoryrollback\gui\Buttons.java
src\main\java\me\danjono\inventoryrollback\gui\menu\PlayerMenu.java
```

普通消息文件：

```text
src\main\resources\messages.yml
```

修改 `messages.yml` 后，可以使用：

```text
/ir reload
```

重新加载消息配置。

但是，Java 源码中的 GUI 标题和按钮名称是写死的，修改后必须重新编译插件，单独执行 `/ir reload` 不会生效。

## 八、安装编译后的插件

1. 关闭 Paper 或 Leaves 服务端。
2. 备份服务器原有的 InventoryRollbackPlus 插件。
3. 将下面的文件复制到服务器的 `plugins` 目录：

```text
target\InventoryRollbackPlus-1.8.4.jar
```

4. 删除旧版重复 JAR，避免同时加载两个版本。
5. 启动服务器。
6. 检查控制台是否正常加载插件。

不要把以下内容复制到服务器：

```text
src\
pom.xml
BukkitVersion-0.0.22.jar
target\classes\
```

服务器只需要最终生成的插件 JAR。

## 九、常见编译错误

### 1. 找不到 BukkitVersion

错误：

```text
package com.tcoded.lightlibs.bukkitversion does not exist
```

解决方法：

重新执行第四节中的本地依赖安装命令。

同时确认文件存在：

```text
D:\XT\MC_BC\群组服\插件\Inventory-Rollback-Plus\BukkitVersion-0.0.22.jar
```

### 2. Unknown lifecycle phase

错误：

```text
Unknown lifecycle phase ".tcoded.lightlibs"
```

原因通常是 PowerShell 将 `-DgroupId=com.tcoded.lightlibs` 拆开了。

解决方法：

使用带引号的写法：

```powershell
"-DgroupId=com.tcoded.lightlibs"
```

不要直接写成没有引号、且被网页换行破坏的命令。

### 3. 找不到 Java 8

错误：

```text
Cannot find a Java installation matching languageVersion=8
```

解决方法：

确认 IDEA、Maven Runner 和系统环境变量都使用 JDK 8，而不是 JRE、JDK 21 或 JDK 25。

检查 Java 版本：

```powershell
java -version
javac -version
mvn -version
```

输出中应该能看到 Java 8。

### 4. Maven 使用了错误的本地仓库

如果依赖明明安装过，编译仍然提示找不到，请明确指定：

```text
-Dmaven.repo.local=C:\Users\29706\.m2\repository
```

## 十、更新源码时的注意事项

如果以后从上游仓库合并更新：

1. 先备份当前三个中文化文件。
2. 检查以下文件是否被上游覆盖：

```text
InventoryName.java
Buttons.java
PlayerMenu.java
```

3. 重新确认中文 GUI 文本是否还存在。
4. 重新安装 BukkitVersion 本地依赖。
5. 重新执行 Maven 编译。
6. 编译成功后再替换服务器插件。

当前版本只是个人定制版，版本号仍保持 `1.8.4`，方便与原作者版本对应。
```