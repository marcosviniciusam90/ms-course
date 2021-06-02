# Testando CORS

No navegador, abra a **Ferramenta de desenvolvedor (F12)**, na aba **Console**, cole o código abaixo e dê ENTER.

<pre>
fetch("http://localhost:8765/hr-worker/workers", {
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MjI2ODU0NDEsInVzZXJfbmFtZSI6ImxlaWFAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9PUEVSQVRPUiIsIlJPTEVfQURNSU4iXSwianRpIjoiYjYzNmRiYTktNzJjNS00Y2QxLWE1YzUtNjY4Nzg1ZjRkMWUwIiwiY2xpZW50X2lkIjoibXlhcHBuYW1lMTIzIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.F7BayWsUNiLdl11g196gszqe_IM_Sysp95_MN2lH-GE",
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "cross-site"
  },
  "referrer": "http://localhost:3000",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors",
  "credentials": "omit"
});
</pre>