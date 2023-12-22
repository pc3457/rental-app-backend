package com.company.riderental.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RideShareDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public RideShareData insert(RideShareData rideShareData) throws SQLException {

        String sql = "INSERT INTO dbo.RideshareData(id, hour, day, month, datetime, source, destination, "
                + "product_id, name, price, distance, surge_multiplier, latitude, longitude, "
                + "temperature, short_summary, precip_probability, visibility, driver_rating, "
                + "rider_rating, rating) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new PreparedStatementSetter(){


            public void setValues(PreparedStatement insertStatement) throws SQLException {
                insertStatement.setString(1, rideShareData.getId());
                insertStatement.setDouble(2, rideShareData.getHour());
                insertStatement.setInt(3, rideShareData.getDay());
                insertStatement.setInt(4, rideShareData.getMonth());
                insertStatement.setString(5, rideShareData.getDatetime());
                insertStatement.setString(6, rideShareData.getSource());
                insertStatement.setString(7, rideShareData.getDestination());
                insertStatement.setString(8, rideShareData.getProductId());
                insertStatement.setString(9, rideShareData.getName());
                insertStatement.setDouble(10, rideShareData.getPrice());
                insertStatement.setDouble(11, rideShareData.getDistance());
                insertStatement.setDouble(12, rideShareData.getSurgeMultiplier());
                insertStatement.setDouble(13, rideShareData.getLatitude());
                insertStatement.setDouble(14, rideShareData.getLongitude());
                insertStatement.setDouble(15, rideShareData.getTemperature());
                insertStatement.setString(16, rideShareData.getShortSummary());
                insertStatement.setDouble(16, rideShareData.getPrecipProbability());
                insertStatement.setDouble(16, rideShareData.getVisibility());
                insertStatement.setDouble(16, rideShareData.getDriverRating());
                insertStatement.setDouble(16, rideShareData.getRiderRating());
                insertStatement.setDouble(16, rideShareData.getRating());

            }
        });

        return rideShareData;
    }

    public RideShareData update(RideShareData rideShareData) throws SQLException{

        String sql = "UPDATE dbo.RideshareData SET price = price * ? WHERE product_id = ? AND distance = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter(){
            public void setValues(PreparedStatement updateStatement) throws SQLException{
                updateStatement.setDouble(1, rideShareData.getSurgeMultiplier());
                updateStatement.setString(2, rideShareData.getProductId());
                updateStatement.setDouble(3, rideShareData.getDistance());
            }
                });


        return rideShareData;
    }

    public void delete(RideShareData rideShareData) throws SQLException{

        String sql = "DELETE FROM dbo.RideshareData WHERE id = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter(){
                    public void setValues(PreparedStatement deleteStatement) throws SQLException{
                        deleteStatement.setString(1, rideShareData.getId());
                    }
                });

        //PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM RideshareData WHERE id = ?");



    }

    public List<RideShareData> read() throws SQLException {
        String sql = "SELECT price, surge_multiplier, datetime, driver_rating, product_id, name FROM dbo.RideshareData";
        List<RideShareData> rideShares = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RideShareData rideShareData = new RideShareData();
                // Assuming you have a constructor or setters in RideShareData class
                rideShareData.setPrice(rs.getDouble("price"));
                rideShareData.setSurgeMultiplier(rs.getDouble("surge_multiplier"));
                rideShareData.setDatetime(rs.getString("datetime"));
                rideShareData.setDriverRating(rs.getDouble("driver_rating"));
                rideShareData.setProductId(rs.getString("product_id"));
                rideShareData.setName(rs.getString("name"));

                rideShares.add(rideShareData);
            }
        }
        return rideShares;
    }
}
