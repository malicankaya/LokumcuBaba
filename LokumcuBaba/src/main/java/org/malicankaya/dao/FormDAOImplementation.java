package org.malicankaya.dao;

import org.malicankaya.model.FormModel;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class FormDAOImplementation implements FormDAO
{

    private JdbcTemplate jdbcTemplate;

    public FormDAOImplementation(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(FormModel formModel)
    {
        String sql = "INSERT INTO bayibasvurular (ad_soyad, tckimlik," +
                "adres,telefon,eposta,dogum_tarihi,s1,s2,s3,s4,s5) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,formModel.getAdSoyad(),formModel.getTcKimlik(),
                formModel.getAdres(),formModel.getTelefon(),formModel.getEmail(),formModel.getDogumTarihi(),
                formModel.isS1(),formModel.getS2(),formModel.getS3(),formModel.getS4(),formModel.getS5());
    }
}
