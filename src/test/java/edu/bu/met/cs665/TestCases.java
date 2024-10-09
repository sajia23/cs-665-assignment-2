package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class TestCases {

    public DeliveryRequest generateDeliveryRequest(DriverType driverType) {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setCustomerName(RandomStringUtils.random(5, true, false));
        if(driverType != null) {
            deliveryRequest.setRequestDriverType(driverType);
        } else {
            deliveryRequest.setRequestDriverType(DriverType.randomDriverType());
        }
        deliveryRequest.setCustomerPhone(RandomStringUtils.randomNumeric(10));
        deliveryRequest.setCustomerAddress(RandomStringUtils.random(20, true, false));
        deliveryRequest.setItems(RandomStringUtils.random(10, true, false));
        return deliveryRequest;
    }

    public void generateEveryDriver() {
        Shop shop = Shop.getInstance();
        shop.unsubscribeAll();
        for(int i = 0; i < DriverType.values().length; i ++) {
            shop.getRegistedDrivers().registerDriver(DriverFactory.produceDriver(DriverType.values()[i]));
        }
    }

    public void generateCustomerDriver(DriverType[] driverTypes) {
        Shop shop = Shop.getInstance();
        shop.unsubscribeAll();
        for(int i = 0; i < driverTypes.length; i ++) {
            shop.getRegistedDrivers().registerDriver(DriverFactory.produceDriver(driverTypes[i]));
        }
    }

    @Test
    public void regularDelivery() {
        DeliveryRequest deliveryRequest = generateDeliveryRequest(DriverType.VAN);
        generateEveryDriver();
        Shop.getInstance().placeTheOrder(deliveryRequest);

        DriversIterator driversIterator = Shop.getInstance().getRegistedDrivers().createIterator();
        while (driversIterator.hasNext()) {
            Driver driver = (Driver)driversIterator.next();
            if(driver.getDriverType().equals(DriverType.VAN)) {
                assertEquals(driver.getRegistrationNumber(), deliveryRequest.getDriverRegisterNumber());
            }
        }
    }

    @Test
    public void regularDeliveryCheckState() {
        DeliveryRequest deliveryRequest = generateDeliveryRequest(DriverType.VAN);
        generateEveryDriver();
        Shop.getInstance().placeTheOrder(deliveryRequest);

        assertEquals("Begin to broadcast the request to drivers!", deliveryRequest.getDeliveryLogs().get(0));
        assertEquals("Van Driver begin to deal with order!", deliveryRequest.getDeliveryLogs().get(1));
        assertEquals("The request has been finished", deliveryRequest.getDeliveryLogs().get(2));
    }

    @Test
    public void regularDeliveryWithAppointedDriver() {
        DeliveryRequest deliveryRequest = generateDeliveryRequest(DriverType.VAN);
        generateCustomerDriver(new DriverType[]{DriverType.VAN});
        Shop.getInstance().placeTheOrder(deliveryRequest);

        DriversIterator driversIterator = Shop.getInstance().getRegistedDrivers().createIterator();
        while (driversIterator.hasNext()) {
            Van driver = (Van) driversIterator.next();
            assertEquals(driver.registrationNumber, deliveryRequest.getDriverRegisterNumber());
        }
    }

    @Test
    public void deliveryWithDriverNotEqualWithAppointed() {
        DeliveryRequest deliveryRequest = generateDeliveryRequest(DriverType.VAN);
        generateCustomerDriver(new DriverType[]{DriverType.CAR});
        Shop.getInstance().placeTheOrder(deliveryRequest);

        assertEquals("Begin to broadcast the request to drivers!", deliveryRequest.getDeliveryLogs().get(0));
        assertEquals("No appropriate driver to do the job!", deliveryRequest.getDeliveryLogs().get(1));
    }
}
