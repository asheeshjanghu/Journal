package com.memory.Journal.util;

import com.memory.Journal.model.MemoryImageData;

public interface StorageService {

    public boolean saveFile(MemoryImageData memoryImageData);

    public boolean deleteFile(String fileName);

    public void getFile(String fileName);
}
