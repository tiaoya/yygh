<template>
  <div class="app-container">
    <el-form label-width="120px" :rules="rulesx" :model="hospset" ref="hospset">
      <el-form-item label="医院名称" prop="hosname">
        <el-input v-model="hospset.hosname" />
      </el-form-item>

      <el-form-item label="医院编号">
        <el-input v-model="hospset.hoscode" />
      </el-form-item>

      <el-form-item label="api地址">
        <el-input v-model="hospset.apiUrl" />
      </el-form-item>

      <el-form-item label="联系人">
        <el-input v-model="hospset.contactsName" />
      </el-form-item>

      <el-form-item label="电话" prop="contactsPhone">
        <el-input v-model="hospset.contactsPhone" />
      </el-form-item>

      <el-form-item>
        <!-- @click="saveOrUpdate('hospset')" 里面的参数是做二次校验用的 -->
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate('hospset')"
          >保存</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import hospset from "@/api/hospset.js";
export default {
  data() {
    return {
      saveBtnDisabled: false,
      hospset: {},
      rulesx: {
        hosname: [
          { required: true, message: "请输入医院名称", trigger: "blur" },
          {
            min: 3,
            max: 10,
            message: "长度在 3 到 10 个字符",
            trigger: "blur",
          },
        ],
        contactsPhone: [
          { required: true, message: "请输入手机号", trigger: "blur" },
          { min: 11, max: 11, message: "请输入正确的手机号", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    saveOrUpdate(formName) {
      this.$refs[formName].validate((valid) => {

        if (valid) {
          this.saveBtnDisabled = true;
          hospset.addHospital(this.hospset).then((resp) => {
            this.$message.success("添加成功");
            // 跳转列表页面
            this.$router.push({ path: "/yygh/hospset/list" });
          });
        }else{
          this.$message.error("表单填写有误")
          return false;
        }
      });
    },
  },
};
</script>

