package umc.spring.service.RegionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;

@Service
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService {
    @Override
    public void CheckRegion(Boolean flag) {
        if (!flag) {
            throw new RegionHandler(ErrorStatus.REGION_NOT_FOUND);
        }
    }
}
