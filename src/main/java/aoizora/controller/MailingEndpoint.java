package aoizora.controller;

import aoizora.converter.MailingConverter;
import aoizora.model.MailingDTO;
import aoizora.service.MailingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "API для работы с почтовыми отправлениями", produces = "application/json")
@Controller
@RequestMapping("/api/mailing")
public class MailingEndpoint
{
    private final MailingService mailingService;

    private final MailingConverter mailingConverter;

    public MailingEndpoint(MailingService mailingService, MailingConverter mailingConverter)
    {
        this.mailingService = mailingService;
        this.mailingConverter = mailingConverter;
    }

    @ApiOperation(value = "Зарегистрировать почтовое отправление", produces = "application/json")
    @PostMapping("/register")
    public ResponseEntity<MailingDTO> register(@RequestBody MailingDTO mailing)
    {
        return ResponseEntity.ok(mailingConverter.convert(mailingService.register(
                mailing.getRecipient(),
                mailing.getType(),
                mailing.getAddress(),
                mailing.getPostcode()
        )));
    }
}
