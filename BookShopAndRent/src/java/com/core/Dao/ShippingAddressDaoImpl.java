/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Dao;

import com.core.classes.UserShippingAdd;
import com.core.servlets.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kapil
 */
public class ShippingAddressDaoImpl implements ShippingAddressDao {

    public List<UserShippingAdd> getAddress(String userId) {

        List<UserShippingAdd> list = new ArrayList();
        // database code

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            con = new connection().dbConnection();
            st = con.prepareStatement("select shipping_address,pincode from user_shipping_address where user_id=?");
            st.setString(1, userId);
            rs = st.executeQuery();
            while (rs.next()) {
                UserShippingAdd add = new UserShippingAdd(rs.getString("shipping_address"),rs.getString("pincode"));
                list.add(add);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {
            }

        }

        return list;
    }

}
