<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="数据加载中"
      border
      fit
      highlight-current-row
    >
      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="hosname" label="医院名称" width="180" />
      <el-table-column prop="hoscode" label="医院编号" width="160" />
      <el-table-column prop="apiUrl" label="地址" width="200" />
      <el-table-column prop="contactsName" label="联系人" />
      <el-table-column prop="status" label="状态">
        <template slot-scope="scope">
          {{ scope.row.status === 1 ? "可用" : "不可用" }}
        </template>
      </el-table-column>

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/yygh/hospset/edit/' + scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit"
              >修改</el-button
            >
          </router-link>
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            @click="removeDataById(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center"
      layout="total, prev, pager, next, jumper"
      @current-change="handleCurrentChange"
    />
  </div>
</template>
<script>
import hospset from "@/api/hospset.js";
export default {
  data() {
    return {
      //变量：值
      list: [],
      total: 0,
      searchObj: {},
      listLoading: false,
      page: 1,
      limit: 3,
    };
  },
  methods: {
    // es6 新特性，可以在参数位置添加默认值
    getPageInfo(val = 1) {
      this.page = val;
      hospset
        .getHospsetPage(this.page, this.limit, this.searchObj)
        .then((resp) => {
          this.total = resp.data.total;
          this.list = resp.data.rows;
        });
    },

    handleCurrentChange(val){
        this.getPageInfo(val);
    }

  },

  created() {
    this.getPageInfo();
  },
};
</script>

