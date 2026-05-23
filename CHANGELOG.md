# Changelog

## [1.2.0]
- Add AccessLog entity for full audit trail of entry/exit events
- Add POST /access/verify endpoint — logs access attempt and returns result
- Fix: cards with active=false now correctly denied at verify endpoint

## [1.1.0]
- Add role-based card model (admin, user, guest)
- Add application.properties with env variable support
- Add Spring Security basic config

## [1.0.0]
- Initial release
- Card registration, listing, and deletion
- MySQL persistence with Spring Data JPA