package com.onlineexam.dao;

import java.sql.Blob;

public interface CommonDAO {    
    public Blob getBlob(byte[] is);
}
