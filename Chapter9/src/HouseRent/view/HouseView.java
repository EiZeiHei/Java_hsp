package HouseRent.view;

import HouseRent.domain.House;
import HouseRent.service.HouseService;
import HouseRent.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        do {
            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");

            System.out.println();

            int key;
            do {
                System.out.print("请选择（1-6）：");
                key = Utility.readInt();
                if (key > 0 && key < 7) {
                    break;
                } else {
                    System.out.println("请输入（1-6）的数字");
                }
            } while (true);
            System.out.println();

            switch (key) {
                case (1) -> addHouse();
                case (2) -> findHouse();
                case (3) -> deleteHouse();
                case (4) -> updateHouse();
                case (5) -> listHouse();
                case (6) -> exitHouse();
                default -> {
                }
            }
        } while (loop);
    }

    //1 Add
    public void addHouse() {
        System.out.println("------------添加房屋------------");
        System.out.print("姓名：");
        String name = Utility.readString(10);
        System.out.print("电话：");
        String phone = Utility.readString(10);
        System.out.print("地址：");
        String address = Utility.readString(10);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态（未出租/已出租）：");
        String state = Utility.readString(10);

        House house = new House(0, name, phone, address, rent, state);
        houseService.add(house);
        System.out.println("------------添加完成------------");
        System.out.println();
    }

    //2 Find
    public void findHouse() {
        System.out.println("------------查找房屋------------");
        System.out.print("请输入你要查找的id：");
        int id = Utility.readInt();

        House house = houseService.find(id);

        if (house == null) {
            System.out.println("------------未找到房屋------------");
        } else {
            System.out.println(house);
        }
        System.out.println();
    }

    //3 Delete
    public void deleteHouse() {
        System.out.println("------------删除房屋------------");
        System.out.print("请选择待删除房屋编号（-1退出）：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }

        char choice = Utility.readConfirmSelection();
        if (choice == 'N') {
            return;
        }

        if (!houseService.delete(id)) {
            System.out.println("------------无此编号，删除失败------------");
        } else {
            System.out.println("------------删除完成------------");
        }
        System.out.println();
    }

    //4 Update
    public void updateHouse() {
        System.out.println("------------修改房屋------------");
        System.out.print("请选择待修改房屋编号（-1退出）：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }

        House house = houseService.find(id);

        System.out.print("姓名（" + house.getName() + "）：");
        String name = Utility.readString(10, "");
        if (!name.equals("")) {
            house.setName(name);
        }

        System.out.print("电话（" + house.getPhone() + "）：");
        String phone = Utility.readString(10, "");
        if (!phone.equals("")) {
            house.setPhone(phone);
        }

        System.out.print("地址（" + house.getAddress() + "）：");
        String address = Utility.readString(10, "");
        if (!address.equals("")) {
            house.setAddress(address);
        }

        System.out.print("租金（" + house.getRent() + "）：");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }

        System.out.print("状态（" + house.getState() + "）：");
        String state = Utility.readString(10, "");
        if (!state.equals("")) {
            house.setState(state);
        }

        System.out.println("------------修改完成------------");
        System.out.println();
    }

    //5 List
    public void listHouse() {
        System.out.println("------------房屋列表------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");

        House[] houses = houseService.list();
        for (House house : houses) {
            if (house != null) {
                System.out.println(house);
            } else {
                break;
            }
        }
        System.out.println();
    }

    //6 Exit
    public void exitHouse() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        }
        System.out.println();
    }
}
