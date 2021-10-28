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
