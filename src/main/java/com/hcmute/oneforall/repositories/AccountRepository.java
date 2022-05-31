package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
    Account findById(int id);
    @Override
    ArrayList<Account> findAll();

    @Modifying
    @Query(value = "UPDATE Account a SET a.mat_khau = :password WHERE a.id = :id")
    @Transactional
    void updatePassword(@Param("id") int id, @Param("password") String password);

    @Modifying
    @Query(value = "UPDATE Account a SET a.ho = :ho, a.ten = :ten, a.ngay_sinh = :ngaysinh, a.gioi_tinh = :gioitinh, a.email = :email, a.sdt = :sdt WHERE a.id = :id")
    @Transactional
    void update(@Param("id") int id,
                @Param("ho") String ho,
                @Param("ten") String ten,
                @Param("ngaysinh") Date ngaysinh,
                @Param("gioitinh") boolean gioitinh,
                @Param("email") String email,
                @Param("sdt") String sdt);

    @Query(value = "SELECT MAX (a.id) FROM Account a")
    int size();
}
