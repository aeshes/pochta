package aoizora.controller;

import aoizora.converter.HistoryConverter;
import aoizora.model.HistoryDTO;
import aoizora.service.HistoryService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "API для работы с историей отправлений", produces = "application/json")
@RequestMapping("/api/history")
@Controller
public class HistoryEndpoint
{
    private final HistoryService historyService;

    private final HistoryConverter historyConverter;

    public HistoryEndpoint(HistoryService historyService, HistoryConverter historyConverter)
    {
        this.historyService = historyService;
        this.historyConverter = historyConverter;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HistoryDTO>> getAll(@RequestParam Long id)
    {
        return ResponseEntity.ok(historyConverter.convert(historyService.getAll(id)));
    }
}
