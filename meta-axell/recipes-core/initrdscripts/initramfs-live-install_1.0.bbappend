FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = " file://init-install-set-grub-timeout-0.patch;patchdir=${WORKDIR}"
