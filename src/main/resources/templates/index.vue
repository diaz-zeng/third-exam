<!DOCTYPE html>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>账本</title>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.css"
          th:href="@{/bootstrap/css/bootstrap.css}"/>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap-grid.css"
          th:href="@{/bootstrap/css/bootstrap-grid.css}"/>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap-reboot.css"
          th:href="@{/bootstrap/css/bootstrap-reboot.css}"/>
</head>
<body>
<div class="container" id="App">
    <div class="card">
        <div class="card-header">
            <h3 class="text-center">账单管理</h3>
        </div>
        <div class="card-body">
            <div class="form-inline">
                <label for="type">类型</label>
                <select class="form-control mx-auto" name="type" id="type">
                    <option v-for="option in options" :key="option.value" :value="option.value"
                            v-text="option.title"></option>
                </select>
                <label for="start">日期：从</label>
                <input class="form-control mx-auto" type="date" name="start" id="start">
                <label for="end">到</label>
                <input class="form-control mx-auto" type="date" name="end" id="end">
                <div class="mx-auto">
                    <button class="form-control btn btn-primary" type="button">查账</button>
                    <button class="form-control btn btn-secondary" type="button">记账</button>
                </div>
            </div>
            <div class="my-5">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>时间</th>
                        <th>类别</th>
                        <th>金额</th>
                        <th>说明</th>
                    </tr>
                    </thead>
                    <tbody v-if="rows!==null&&rows!==''">
                    <tr v-for="r in rows">
                        <td v-cloak>{{r.title}}</td>
                        <td v-cloak>{{r.date | dateFormat}}</td>
                        <td v-cloak>{{r.type.title}}</td>
                        <td v-cloak>{{r.price}}</td>
                        <td v-cloak>{{r.info}}</td>
                    </tr>
                    </tbody>
                    <tbody v-else>
                    <tr>
                        <td colspan="5"><h3 class="text-center">暂无数据</h3></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer">
            <div class="form-inline">
                <div class="m-auto">
                    <button class="btn">上一页</button>
                    当前第{{currentPage}}页
                    <button class="btn">下一页</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
<script src="../static/js/jquery.js" th:src="@{/js/jquery.js}"></script>
<script src="../static/js/vue.js" th:src="@{/js/vue.js}"></script>
<script src="../static/js/vue-resource.js" th:src="@{/js/vue-resource.js}"></script>
<script src="../static/bootstrap/js/bootstrap.js" th:src="@{/bootstrap/js/bootstrap.js}"></script>
<script src="../static/bootstrap/js/bootstrap.bundle.js" th:src="@{/bootstrap/js/bootstrap.bundle.js}"></script>
<script src="../static/js/common.js" th:src="@{/js/common.js}"></script>
<script>
    var vmCommon = new Vue({
        el: "#App",
        data: {
            options: [new Type(0, '不限'), new Type(1, '支出'), new Type(2, '收入')],
            rows: null,
            currentPage: 1
        },
        methods: {
            getRowsByPage(currentPage = this.currentPage) {
                this.$http.post()
            }
        },
        created: function () {

        }
    });
</script>
</html>