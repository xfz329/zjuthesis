public class SpecificReader implements PPGReader{
    @Override
    public PERecord readFromFile(String file) {
        // 定义存储读取结果的PERecord变量 record。
        PERecord record = new PERecord();
        // 根据特定的数据存储格式从文件中读取数据，此过程与具体硬件设备绑定。
        record.read(file);
        // 设置rcd的采样率、采样时间、被采集者姓名等信息。
        record.setOtherAttributes();
        // 返回读取结果。
        return record;
    }
}