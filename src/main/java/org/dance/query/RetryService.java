package org.dance.query;

import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	@Retryable(value = { SQLException.class }, maxAttempts = 2, backoff = @Backoff(delay = 5000))
	void retryService(String sql) throws SQLException {
		System.out.println("in retry Service ...");
		throw new SQLException();
	}
	
	@Recover
    void recover(SQLException e, String sql) {
		System.out.println("In Recover");
	}

}
