package com.makschornyi.queryvsspringdata.service;

import com.makschornyi.queryvsspringdata.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;


}
