package tn.zoubeidi.conversionoperation.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import tn.zoubeidi.conversionoperation.domain.Currency;
import tn.zoubeidi.conversionoperation.domain.Operation;
import tn.zoubeidi.conversionoperation.repository.OperationRepository;
import tn.zoubeidi.conversionoperation.service.rest.GetConversionRate;
import tn.zoubeidi.conversionoperation.service.rest.GetConversionRateImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static tn.zoubeidi.conversionoperation.TestUtils.*;

class OperationServiceImplTest {

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private GetConversionRateImpl getConversionRate;
    @InjectMocks
    private OperationServiceImpl operationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void convertTest() {

        // given
        when(getConversionRate.getConversionRate(FROM, TO)).thenReturn(RATE);
        when(operationRepository.saveAndFlush(any())).then(returnsFirstArg());

        // when
        Operation operation = operationService.convert(FROM, TO, INITIAL_AMOUNT);

        // then
        assertNotNull(operation);
        assertEquals(EXPECTED_AMOUNT, operation.getConvertedAmount());
        assertEquals(EXPECTED_AMOUNT, operation.getConvertedAmount());
        assertEquals(RATE, operation.getConversionRate());

    }

}