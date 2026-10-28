# 开发指南

## 打开项目

用 IntelliJ IDEA 打开项目根目录 `E:\demo-skeleton`，等待 Maven 导入完成。

## 构建

```cmd
mvn test
```

## 运行

运行 `DemoApplication` 的 `main` 方法，正常输出：

```text
Demo application started: demo-skeleton
```

## 配置

运行配置位于 `src/main/resources/application.properties`。不要把密码、令牌等
敏感信息提交到仓库；本地敏感配置应放入已被 `.gitignore` 排除的文件。

## 开发约定

- Java 源文件统一使用 UTF-8 和 4 个空格缩进。
- 新增生产行为时先添加可复现失败场景的测试。
- 提交前至少运行一次 `mvn test`。
