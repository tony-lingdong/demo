package com.hld.service;

import com.hld.entities.Address;

import java.util.List;

public interface AddressService {
    void InsertAddress(Address address);
    List<Address> getAllAddress(int user_id);
    Address getAllAddressById(int id);
}
