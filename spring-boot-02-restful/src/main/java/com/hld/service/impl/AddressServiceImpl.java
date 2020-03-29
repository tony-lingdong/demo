package com.hld.service.impl;

import com.hld.entities.Address;
import com.hld.mapper.AddressMapper;
import com.hld.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public void InsertAddress(Address address) {
        addressMapper.InsertAddress(address);
    }

    @Override
    public List<Address> getAllAddress(int user_id) {
        return addressMapper.getAllAddress(user_id);
    }

    @Override
    public Address getAllAddressById(int id) {
        return addressMapper.getAllAddressById(id);
    }
}
