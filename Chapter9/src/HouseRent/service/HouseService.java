package HouseRent.service;

import HouseRent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum;
    private int idNum;

    public HouseService(int size) {
        houses = new House[size];
    }

    //1 Add
    public void add(House house) {
        if (houseNum + 1 == houses.length) {
            House[] housesNew = new House[houses.length + 5];
            System.arraycopy(houses, 0, housesNew, 0, houses.length);
            houses = housesNew;
        }

        house.setId(++idNum);
        houses[houseNum++] = house;
    }

    //2 Find
    public House find(int id) {
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }

    //3 Delete
    public boolean delete(int id) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        if (houseNum - 1 - index >= 0) System.arraycopy(houses, index + 1, houses, index, houseNum - 1 - index);
        houses[--houseNum] = null;
        return true;
    }

    //5 List
    public House[] list() {
        return houses;
    }
}
