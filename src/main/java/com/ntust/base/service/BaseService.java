package com.ntust.base.service;

import com.ntust.base.service.dto.ResponseDto;

public abstract class BaseService<RequestInput, ResponseOutput> {
    public ResponseDto<ResponseOutput> request(RequestInput input) {
        ResponseOutput data = processData(input);
        return generateResult(data);
    }

    public abstract ResponseOutput processData(RequestInput input);

    public abstract ResponseDto<ResponseOutput> generateResult(ResponseOutput data);
}
