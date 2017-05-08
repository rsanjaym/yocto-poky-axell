FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = " file://init-install-efi-set-grub-timeout-0.patch;patchdir=${WORKDIR}"
