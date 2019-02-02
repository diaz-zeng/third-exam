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
        <form>
            <div class="card-header">
                <h3 class="text-center">记账</h3>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="type">类型：</label>
                    <div class="form-control" id="type">
                        <span v-for="option in options">
                        {{option.title}}
                        <input name="type" type="radio" :value="option.value"/>
                    </span>
                    </div>
                    <label for="title">标题：</label>
                    <input class="form-control" type="text" name="title" id="title"/>
                    <label for="date">日期：</label>
                    <input class="form-control" type="date" id="date" name="date">
                    <label for="price">金额：</label>
                    <input class="form-control" type="number" id="price" name="price">
                    <label for="info">说明：</label>
                    <textarea class="form-control" name="info" id="info" cols="50" rows="7"></textarea>
                </div>
            </div>
            <div class="card-footer">
                <div class="form-inline">
                    <div class="mx-auto">
                        <button class="btn btn-primary mx-3" type="reset">重置</button>
                        <button class="btn btn-success mx-3" type="submit">提交</button>
                        <button class="btn btn-secondary mx-3" type="button">返回</button>

                    </div>
                </div>
            </div>
        </form>
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
    var vm = new Vue({
        el: "#App",
        data: {
            options: [new Type(0, '不限'), new Type(1, '支出'), new Type(2, '收入')],
            rows: [new Row('test'), new Row('test'), new Row('test')]

        },
        methods: {}
    });
</script>
</html>