import api from '../../api/file-api.js';

export default {
	namespaced: true,
	actions: {
		uploadFiles({dispatch}, params) {
			api.uploadFiles(params.files, params.service, params.tagId).then((response) => {
				console.log('Upload successful', {noFiles: params.files.length});
				switch (params.service) {
				case 'COURSE':
					dispatch('course/getCourse', params.tagId, {root: true});
					break;
				case 'TASK':
					dispatch('tasks/getTask', params.tagId, {root: true});
					break;
				}
			}).catch((error) => {
				console.error('Upload unsuccessful', error);
			});
		}
	},
	mutations: {},
	state: {}
};
