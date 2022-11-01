<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="name" label="名称" width="180"></el-table-column>

      <el-table-column prop="dictCode" label="编码" width="180">
      </el-table-column>

      <el-table-column prop="value" label="值"> </el-table-column>

      <el-table-column prop="createTime" label="创建时间"> </el-table-column>
    </el-table>
  </div>
</template>
<script>
import dict from "@/api/dict.js";

export default {
  data() {
    return {
        list:[],
    };
  },
  methods:{
    /*
        console.log(row); 当前行数据
        console.log(treeNode);   
        console.log(resolve);  是一个函数,作用将当前的子元素挂载到当前元素下边
    */ 
    load(row,treeNode,resolve){
        
        dict.getDictList(row.id).then(resp=>{
            resolve(resp.data.items);
        })

    }
  },

  created() {
    dict.getDictList(1).then((resp) => {
        this.list = resp.data.items;
    });
  },
};
</script>
