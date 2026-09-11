# Java 基础学习仓库（学习计划与示例）

简短说明
- 目标：为 Java 后端初学者提供系统化的学习路线、每日/每周任务、练习题与示例项目脚手架，方便在本仓库里逐步完成练习、提交代码与记录学习笔记。
- 适用人群：有编程基础、想系统学习 Java 后端（Spring Boot 等）的同学。

## 目录（建议仓库结构）
- /01-java-core/         — Java 基础（语法、OOP、异常、集合）
- /02-java-advanced/     — 进阶（Stream, Optional, concurrency）
- /03-database/          — 数据库与 JDBC 示例
- /04-spring-boot/       — Spring Boot 示例（小项目、练习）
- /projects/todo/        — Todo 项目完整实现（分步）
- /exercises/            — 每日/每周练习题与参考解答
- README.md              — 本文档
- CONTRIBUTING.md        — 贡献指南
- LICENSE                — 许可证（建议 MIT）

## 先决环境（立即准备）
- JDK 17（推荐）或 JDK 11。设置 JAVA_HOME。
- IDE：IntelliJ IDEA Community（推荐��或 VS Code + Java 插件。
- 构建工具：Maven 或 Gradle（任选一个并在项目中统一）。
- Git 与 GitHub 账号。
- （可选）Docker、Postgres、本地数据库工具（pgAdmin 等）。

## 总体学习路线（8 周示例）
- 周0：环境与工具（IDE、Maven/Gradle、Git、运行第一个程序）。
- 周1：Java 基础（变量、控制结构、方法、类、接口）。
- 周2：面向对象进阶（继承、组合、接口设计、设计模式入门）。
- 周3：集合与泛型、Stream API、Optional。
- 周4：异常处理、IO、NIO、日期时间 API。
- 周5：多线程与并发基础（线程、线程池、synchronized、CompletableFuture）。
- 周6：数据库基础（SQL、JDBC、事务、索引）。
- 周7：Spring Boot 入门（DI、Controller、REST、配置）。
- 周8：项目整合与部署（Spring Data JPA、测试、Docker、部署）。

## 每周目标与每日任务（示例：周1）
- 周目标：掌握 Java 基础语法与函数/类的使用。
- 周一：安装 JDK 与 IDE；写第一个 HelloWorld。
- 周二：变量与基本类型；字符串与常用方法。
- 周三：流程控制（if/switch/for/while）。
- 周四：方法与参数传递；方法重载与可变参数。
- 周五：类与对象；构造方法、this、静态成员。
- 周末：做一个小练习：实现一个简单的学生信息类并在集合中排序。

## 练习题（示例）
- 基础：
  1. 写一个方法反转字符串（不使用 StringBuilder.reverse）。
  2. 实现斐波那契（递归与迭代版本），比较性能。
- 集合与流：
  1. 给定一组用户对象，找出年龄在 20-30 且姓名以 "A" 开头的人数。
  2. 使用 Stream 实现对订单金额分组求和。
- 并发：
  1. 用线程池并发计算 1..N 的和，比较与串行版本的时间。
  2. 模拟库存并发扣减，解决超卖问题（synchronized/数据库事务/乐观锁）。

## 第一个入门项目：Todo REST API（任务分解）
- 目标：实现 CRUD 的 REST 服务，使用 Spring Boot + Spring Data JPA + H2，本地可用 Postman/curl 测试。
- 任务清单：
  1. 初始化项目（Spring Initializr：Spring Web, Spring Data JPA, H2, Validation, Lombok 可选）。
  2. 建立实体 Task（id, title, description, status, createdAt, updatedAt）。
  3. 建 Repository（extends JpaRepository）。
  4. Implement Service（业务逻辑与事务）。
  5. 实现 Controller（API endpoints: list, get, create, update, delete）。
  6. DTO 与请求校验（@Valid）。
  7. 全局异常处理（@ControllerAdvice）。
  8. 单元测试（JUnit5 + Mockito）与集成测试（@SpringBootTest）。
  9. 配置 H2 console（方便调试）。
  10. Dockerfile（可选）与 README 中的运行示例。
- API 示例：
  - POST /api/tasks  — 创建
  - GET /api/tasks   — 列表（分页、按 status 过滤）
  - GET /api/tasks/{id}
  - PUT /api/tasks/{id}
  - DELETE /api/tasks/{id}

## 关键命令（示例）
- 用 Maven：
  - mvn clean package
  - mvn spring-boot:run
- 用 Gradle：
  - ./gradlew bootRun
- 运行 Docker（示例）：
  - docker build -t todo-app .
  - docker run -p 8080:8080 todo-app

## 代码风格与约定（建议）
- 使用 UTF-8 编码与 4 空格缩进（或项目统一 2/4）。
- 按包分层：controller / service / repository / model / dto / config / util。
- 提交信息规范：feat|fix|docs|chore: 简要描述（例如 feat(todo): add create endpoint）。
- 分支策略：feature/xxx、fix/xxx、hotfix/xxx，合并到 main 或 develop。

## 贡献指南（简短）
- Fork → 新建 feature 分支 → 提交 → 发 PR。
- PR 需要包含：功能描述、如何运行、关键测试用例。
- 代码审查：尽量小步提交，写清楚单元测试。

## 学习资源（推荐）
- 官方：Oracle / OpenJDK Java 文档、Spring 官方文档（spring.io）。
- 书籍：Effective Java（推荐读）、Spring in Action。
- 网站：Baeldung（spring & java 教程）、LeetCode（算法练习）、慕课网/极客时间 中文课程。
- 视频课程：Udemy 上 Spring Boot 实战课（如果你习惯英文视频）。

## 如何在仓库中使用这份文档
- 将本文放在仓库根目录的 README.md，或放在 docs/learning-plan.md。
- 在 README 中加入“每日学习进度表/Checklist（To-Do）”，并鼓励用 Issues 跟踪学习任务与作业。
- 每完成一个练习或项目，把代码放到相应目录并写短说明（README 或 module README）。

## 模板：每日学习记录（建议放在 .md 模板文件）
- 日期：
- 今日学习目标：
- 完成情况（0/1/2 表示未完成/部分/完成）：
- 遇到的问题与解决办法：
- 下一步计划：
- 参考资料链接：

## 许可证建议
- MIT（简单开放，适合学习仓库）。在 LICENSE 文件写明。
