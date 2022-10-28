<template>
  <div class="app-container">
     <el-table
        :data="rows"
        stripe
        style="width: 100%">
        
        <el-table-column
        prop="id"
        label="id"
        width="180">
        </el-table-column>
        
        <el-table-column
        prop="createTime"
        label="创建时间"
        width="180">
        </el-table-column>
        
        <el-table-column
        prop="updateTime"
        label="创建时间">
        </el-table-column>
    </el-table>
  
  </div>
</template>
<script>
  import hospset  from '@/api/hospset.js'
  export default {
      data(){
          return {
              //变量：值
              rows:[],
              total:0,
              searchObj:{}
          }
      },
      methods:{

      },
      created(){
          hospset.getHospsetPage(1,5,this.searchObj).then(resp=>{
              this.total=resp.data.total;
              this.rows=resp.data.rows;
          })
      }

  }
</script>

