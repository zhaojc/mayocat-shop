package org.mayocat.shop.shipping.store.memory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mayocat.shop.shipping.Strategy;
import org.mayocat.shop.shipping.model.Carrier;
import org.mayocat.shop.shipping.store.CarrierStore;

/**
 * Tests for {@link MemoryCarrierStore}
 *
 * @version $Id$
 */
public class MemoryCarrierStoreTest
{
    private CarrierStore carrierStore;

    @Before
    public void setUpStore()
    {
        carrierStore = new MemoryCarrierStore();
    }

    @Test
    public void testCreateCarrierAndFindByStrategy()
    {
        Carrier carrier1 = new Carrier();
        carrier1.setStrategy(Strategy.WEIGHT);
        carrierStore.createCarrier(carrier1);

        Carrier carrier2 = new Carrier();
        carrier2.setStrategy(Strategy.FLAT);
        carrierStore.createCarrier(carrier2);

        Carrier carrier3 = new Carrier();
        carrier3.setStrategy(Strategy.WEIGHT);
        carrierStore.createCarrier(carrier3);

        Assert.assertEquals(2, carrierStore.findAll(Strategy.WEIGHT).size());
    }
}
