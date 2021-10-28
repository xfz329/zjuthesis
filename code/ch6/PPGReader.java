public interface PPGReader {
	// 定义了读取文件操作的规范方法
	PERecord readFromFile(String file);
}
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
public class TotalReader {
    public PERecord updateDataset(String file) {
        // 定义存储读取结果的PERecord变量 record。
        PERecord record;
        // 判断是数据是何种硬件设备采集
        DeviceType type = GetDeviceType();
        // 依据采集设备的具体数据存储格式对原始数据进行读取。
        switch(type){
            case DeviceA:
                // DeviceAReader是SpecificReader的实例化，与DeviceA适配。
                DeviceAReader dar= new DeviceAReader();
                // 读取数据
                record = dar.readFromFile(file);
            break;
            case DeviceB:
                ……
        }
        // 返回真正的读取结果，至此，与平台相关的硬件特性全部被封装隐藏。
		return  record;
    }
}
