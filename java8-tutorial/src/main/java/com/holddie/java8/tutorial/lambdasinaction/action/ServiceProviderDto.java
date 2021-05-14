package com.holddie.java8.tutorial.lambdasinaction.action;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class ServiceProviderDto {
    private Long id;
    private String serviceProviderName;
    private String contactName;
    private String contactPhone;
    private String address;
    private String remark;
    private String shortName;

    public static void main(String[] args) {
        ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
        serviceProviderDto.setId(1L);
        serviceProviderDto.setAddress("1");
        ServiceProviderDto serviceProviderDto1 = new ServiceProviderDto();
        serviceProviderDto1.setId(2L);
        serviceProviderDto1.setAddress("2");
        ServiceProviderDto serviceProviderDto2 = new ServiceProviderDto();
        serviceProviderDto2.setId(3L);
        serviceProviderDto2.setAddress("3");
        ServiceProviderDto serviceProviderDto5 = new ServiceProviderDto();
        serviceProviderDto5.setId(1L);
        serviceProviderDto5.setAddress("6");
        List<ServiceProviderDto> list = Arrays.asList(serviceProviderDto1, serviceProviderDto2, serviceProviderDto5, serviceProviderDto);
        // method one
        ArrayList<ServiceProviderDto> collect = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ServiceProviderDto::getId))), ArrayList::new)
        );

        // method two
        List<ServiceProviderDto> values = new ArrayList<>(list.stream().collect(Collectors.toMap(ServiceProviderDto::getId, Function.identity(), (x1, x2) -> x2)).values());
        System.out.println(collect.size());
        System.out.println(values.size());
    }
}