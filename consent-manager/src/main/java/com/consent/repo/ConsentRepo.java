package com.consent.repo;

import com.consent.entity.Consent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentRepo extends JpaRepository<Consent, String> {

}
