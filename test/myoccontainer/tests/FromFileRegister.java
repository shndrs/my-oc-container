/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package myoccontainer.tests;

import com.acidmanic.utility.myoccontainer.Registery;
import com.acidmanic.utility.myoccontainer.Resolver;
import com.acidmanic.utility.myoccontainer.configuration.ConfigurationFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import myoccontainer.models.Car;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class FromFileRegister {

    private final Resolver resolver;

    private final String toreadFile = "test/myoccontainer/tests/data/config.config";
    
    public FromFileRegister() {

        resolver = new Resolver(new Registery().register(toreadFile));

    }

    @Test
    public void resolveCar() {
        try {
            Car car = (Car) resolver.resolve(Car.class);
            car.print();
            Assert.assertTrue(true);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }

    }

    @Test
    public void testSave() {
        try {
            ConfigurationFile.save("config.config", resolver.getRegisteredDependancies());
            Assert.assertTrue(true);
        } catch (Exception ex) {
            Logger.getLogger(LifetimeManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }

}
