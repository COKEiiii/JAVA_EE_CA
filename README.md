
## 🚀 团队协作开发流程指南

### 流程图
    A[克隆项目] --> B[切换到dev分支]
    B --> C[拉取最新代码]
    C --> D[创建功能分支]
    D --> E[开发功能]
    E --> F[提交到功能分支]
    F --> G[推送到远程]
    G --> H[创建PR]
    H --> I[代码审查]
    I --> J{审核通过?}
    J -- 是 --> K[合并到dev]
    J -- 否 --> L[修改后重新提交]
    L --> I

### 第一步：准备开发环境

1.  **克隆项目**（每位组员首次操作）
    ```bash
    git clone https://github.com/COKEiiii/JAVA_EE_CA.git
    cd JAVA_EE_CA
    ```

2.  **切换到开发分支**（确保不在main分支开发）
    ```bash
    git checkout dev
    ```

### 第二步：开始开发新功能

3.  **每次开始新功能前，先同步最新代码**
    ```bash
    git pull origin dev
    ```

4.  **创建自己的功能分支**（非常重要！）
    ```bash
    # 分支命名规范：feature/功能名称-姓名缩写
    git checkout -b feature/user-login-zl  # 示例：开发用户登录功能-张磊
    # 或者
    git checkout -b feature/product-crud-lw  # 示例：开发商品CRUD-李伟
    ```

### 第三步：开发与提交

5.  **在功能分支上进行开发**
    ```bash
    # 编写代码...
    ```

6.  **频繁提交代码**（不要积累大量更改一次性提交）
    ```bash
    git add .
    git commit -m "feat: 实现用户登录接口"
    # 或者
    git commit -m "fix: 修复购物车数量计算bug"
    ```

    **提交信息规范**：
    - `feat:`：新功能
    - `fix:`：修复bug
    - `docs:`：文档更新
    - `style:`：代码格式调整
    - `refactor:`：代码重构

7.  **推送功能分支到远程**（定期推送，避免本地丢失）
    ```bash
    git push -u origin feature/user-login-zl
    ```

### 第四步：完成功能，发起Pull Request (PR)

8.  **开发完成后，在GitHub上创建PR**
    - 访问仓库页面 → 点击 `Pull requests` → `New pull request`
    - `base:` 选择 `dev` ← 这是要合并到的目标分支
    - `compare:` 选择你的功能分支 `feature/xxx`
    - 填写PR标题和描述，说明修改内容
    - **重要：** 在描述中@审核者 (如 @COKEiiii)

9.  **代码审查 (Code Review)**
    - 被@的组员进行代码审查
    - 提出修改建议或直接批准
    - 如果需要修改，直接在原功能分支上修正并推送，PR会自动更新

10. **合并PR**
    - 获得至少1人批准后，由PR创建者或组长合并PR
    - 合并后，删除已合并的功能分支（可选但推荐）

### 第五步：开始下一个功能

11. **切换回dev分支，拉取最新代码（包含刚才合并的功能）**
    ```bash
    git checkout dev
    git pull origin dev
    ```

12. **重复步骤4-10，开发下一个功能**

---

## 🚨 重要注意事项

1.  **永远不要直接向 `main` 或 `dev` 分支直接推送代码**
2.  **每次开始新功能前，务必先 `git pull origin dev`**
3.  **一个功能一个分支，不要在一个分支上开发多个功能**
4.  **遇到冲突时不要慌**：先暂存自己的更改，拉取最新代码，然后解决冲突
5.  **保持沟通**：在团队群里及时同步进度和遇到的问题

## 🆘 遇到问题怎么办？

1.  先查看Git错误信息，通常会有提示
2.  在团队群里提问，附上错误截图
3.  参考Git常用命令：
    ```bash
    git status                  # 查看当前状态
    git log --oneline          # 查看提交历史
    git diff                   # 查看更改内容
    git branch -a              # 查看所有分支
    ```

